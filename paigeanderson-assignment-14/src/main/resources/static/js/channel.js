const messageInput = document.getElementById('message-input');
const chatMessages = document.querySelector('.chat-messages');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const user = JSON.parse(sessionStorage.getItem('username'));

const messages = JSON.parse(sessionStorage.getItem('messages')) || [];

console.log(user, channelId);


//this is good here
const createChatMessageElement = (message) => `
	<div class="message"> <b>${message.userName}</b>: ${message.messageText}</div>
`

//the sendMessage function is good now!! rendering now yayyyy
function sendMessage() {
	const message = {
		userName: user.userName,
		messageText: messageInput.value,
		channelId: channelId,
		userId: user.userId
	}
	messageInput.value = '';
	console.log('sending msg')
	
	fetch(`/channels/${channelId}/createMessage`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/JSON'
		},
		body: JSON.stringify(message)
	}).then(response => 
		response.json())
		.then(data => {
			console.log(data)
			
		}).then( () => getMessages())
	
	messages.push(message)
	chatMessages.innerHTML += createChatMessageElement(message)
	
	messageInput.focus()
	
}

//this is ok just gotta figure out why user is null for the controller probs a service issue
//as of 12/18/24 maybe this isn't even being used? looks like its just creating a chat element.. 
//and then not storing the message hhhh
function getMessages() {
	fetch(`/channels/${channelId}/getMessages`)
		.then(response => response.json())
		.then(message => createChatMessageElement(message))
		localStorage.setItem('messages', JSON.stringify(messages))
}



//also ok
document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
	}
});

//doesn't show other messages from different tabs or whatever when in use
//setInterval(getMessages, 500);