const messageInput = document.getElementById('message-input');
const messageDiv = document.querySelector('.chat-messages');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const user = JSON.parse(sessionStorage.getItem('username'));


console.log(user, channelId);

//the sendMessage function is good now!! just gotta figure out how to render
function sendMessage() {
	const message = {
		userName: user.userName,
		messageText: messageInput.value,
		channelId: channelId,
		userId: user.userId
	}
	console.log('sending msg')
	fetch(`/channels/{channelId}/createMessage`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/JSON'
		},
		body: JSON.stringify(message)
	}).then(response => {
		response.json()
		.then(data => {
			console.log(data)
			
		})
	})
	messageInput.value = '';
	messageInput.focus()
}

function pollMessages() {
	fetch(`/channels/{channelId}/getMessages`)
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


document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
	}
});

//setInterval(pollMessages, 500);


