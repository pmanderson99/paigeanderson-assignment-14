const messageInput = document.getElementById('message-input');
const chatMessages = document.querySelector('.chat-messages');
const channelName = document.getElementById("channel-name")
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const username = sessionStorage.getItem('username')

const messages = JSON.parse(localStorage.getItem('messages')) || []

console.log(username)
console.log(channelId)

setInterval(getMessages, 500)


const createChatMessage = (message) => `
	<div class="message">
		<div class="message-sender"><b>${message.user}</b>:</div>
		<div class="message-text">${message.text}</div>
	</div>
`
/*window.onload = () => {
	messages.forEach((message) => {
		chatMessages.innerHTML += createChatMessage(message)
	})
}*/


/*fetch(`/channels/${channelId}/getMessages`)
	.then(response => response.json())
	.then(data => {
		console.log(data)
});
*/

function sendMessage() {
    
    const message = {
        user: username,
        text: messageInput.value,
        channelId: channelId,
    }
    console.log('sending msg')
	fetch(`/channels/${channelId}/createMessage`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(message)
	}).then(response => {
		console.log(response)
	  })

   	messages.push(message)
    localStorage.setItem('messages', JSON.stringify(messages))

    chatMessages.innerHTML += createChatMessage(message)

    chatMessages.scrollTop = chatMessages.scrollHeight
    
    messageInput.value = '';
    messageInput.focus()
}

function getMessages(){
	fetch(`/channels/${channelId}/getMessages`, {
		method: "POST",
		headers: {
				"Content-Type": "application/json"
		}
		}).then(response => response.json())
		  .then(function (data){ 
		  window.onload = () => {
	    	messages.forEach((message) => {
		    	chatMessages.innerHTML += createChatMessage(message)
	    	})
		}	
		console.log(data)
	})
}

document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
		
	}
});


