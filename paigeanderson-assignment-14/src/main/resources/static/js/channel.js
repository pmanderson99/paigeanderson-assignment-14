const messageInput = document.getElementById('message-input');
const channelId = extractChannelIdFromUrl;
const username = sessionStorage.getItem('username');
const content = messageInput.value.trim()


function extractChannelIdFromUrl() {
	var currentUrl = window.location.href;
	var segments = currentUrl.split('/');
	let channelId = segments[segments.length - 1];
	return channelId
}


function sendMessage() {
	const message = {
		messageText: messageInput.value,
		channel: channelId,
		userName: username
	}
	console.log('sending msg')
	fetch(`/channels/{channelId}/createMessage`, {
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
	 fetch(`/channels/{channelId}/messages`,{
		method: 'POST',
		headers:{
			'Content-Type': 'application/json'
		},
	 })
		.then(response => response.json())
		.then(message => {
			const messageDiv = document.querySelector('.chat-messages');
			messageDiv.innerHTML = '';
			message.forEach(message => {
				const div = document.createElement('div');
				div.classList.add('message');
				div.innerHTML = `${message.userName}: ${message.messageText}`;
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