const messageInput = document.getElementById('message-input');
const channelId = extractChannelIdFromUrl;
const username = sessionStorage.getItem('username');

function extractChannelIdFromUrl() {
	var currentUrl = window.location.href;
	var segments = currentUrl.split('/');
	let channelId = segments[segments.length - 1];
	return channelId
}

//Function to handle sending a message
function sendMessage() {
	const content = messageInput.value.trim()
	const message = {
		"messageInput": messageInput.value,
		"channelId": channelId,
		"userName": username
	}
	console.log('sending msg')
	if (content !== '') {
		const chatMessages = document.querySelector('.chat-messages');
		const messageElement = document.createElement('div');
		messageElement.classList.add('message');
		messageElement.textContent = username + ': ' + content;
		chatMessages.appendChild(messageElement);
		messageInput.value = '';
		chatMessages.scrollTop = chatMessages.scrollHeight;
	}
	fetch(`/channels/{channelId}/createMessage`, {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(message)
	}).then(response => {
		console.log(response)
	})
}

// Event listener
document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
	}
});

