let messageInput = document.getElementById('message-input');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const channelName = document.getElementById('channel-name').innerText;
const username = sessionStorage.getItem('username');
const content = messageInput.value.trim();



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
		console.log(response)
	})
	messageInput.value = '';
	messageInput.focus()
}

function pollMessages() {
	fetch(`/channels/${channelId}/getMessages`)
		.then(response => response.json())
		.then(data => {
			const messageDiv = document.querySelector('.chat-messages');
			messageDiv.innerHTML = '';
			data.forEach(message => {
				const div = document.createElement('div');
				div.classList.add('message');
				div.innerHTML = '<b>' + username + '</b>: '+ `${message.messageText}`;
				messageDiv.appendChild(div);
			});
		})

}


document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
	}
});

setInterval(pollMessages, 500);