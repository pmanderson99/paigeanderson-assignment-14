const messageInput = document.getElementById('message-input');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const username = sessionStorage.getItem('username');
const messageDiv = document.querySelector('.chat-messages');
let messageIdCounter = 0;
console.log(channelId, username);

function sendMessage() {
	
	const message = {
		messageText: messageInput.value,
		channelId: channelId,
		userName: username
	}
	console.log('sending msg')
	fetch(`/channels/${channelId}/createMessage`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(message)
	}).then(response => {
		response.json()
		.then(data => {
			console.log(data)
			messageIdCounter = data.messageId;
			console.log(messageIdCounter);
		})
		
			/*const div = document.createElement('div');
				div.classList.add('message');
				div.innerHTML = '<b>' + username+ '</b>: '+ message.messageText;
				messageDiv.appendChild(div);*/
	})
	messageInput.value = '';
	messageInput.focus()
}

function getMessages() {
	fetch(`/channels/${channelId}/getMessages`)
		.then(response => response.json())
		.then(data => {
			const messageDiv = document.querySelector('.chat-messages');
			messageDiv.innerHTML = '';
			data.forEach(message => {
				const div = document.createElement('div');
				div.classList.add('message');
				div.innerHTML = '<b>' + username + '</b>: ' + message.messageText
				messageDiv.appendChild(div);
			});
		})

}
			//const messageDiv = document.querySelector('.chat-messages');
			/*messageDiv.innerHTML = '';
			message.forEach(message => {
				const div = document.createElement('div');
				div.classList.add('message');
				div.innerHTML = '<b>' + username + '</b>: '+ message.messageText;
				messageDiv.appendChild(div);*/
			//});
		//})
		//messageId var that changes with polling
		//var messageIdCounter
		//for each poll, checks to see if mIdCounter is less than largest messageId
		//if mostRecentMessageId = largestMessageId then no messages





document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
		
	}
});

setInterval(getMessages, 500);