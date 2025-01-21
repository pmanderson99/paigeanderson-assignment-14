const messageInput = document.getElementById('message-input');
const chatMessages = document.querySelector('.chat-messages');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const user = sessionStorage.getItem('username');
const userId = sessionStorage.getItem('userId');

const messages = JSON.parse(sessionStorage.getItem('messages')) || [];


console.log("userId of user on channel: " + userId);
console.log(user, channelId);


document.addEventListener('DOMContentLoaded', () => {
	getMessages();
	const msgsFromLocalStorage = JSON.parse(localStorage.getItem('messages')) || [];
	
	if(msgsFromLocalStorage > 0) {
		createMessageElement(msgsFromLocalStorage);
	}
});


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
			.then(data =>{
				console.log(data)
			})
	messages.push(message)
	chatMessages.innerHTML += createMessageElement(message)	
	messageInput.focus()	
}

function getMessages() {
	const sentMessages = JSON.parse(localStorage.getItem('messages')) || [];
	fetch(`/channels/${channelId}/getMessages`)
		.then(response => response.json())
		.then((messages) => {
			const newMessages = messages.filter((message) => {
				return message.channelId == channelId;
			});
			
			if (newMessages.length > sentMessages?.length) { }
			createMessageElement(newMessages);
			
			localStorage.setItem('messages', JSON.stringify(newMessages));
			
		})
}

const createMessageElement = (message) => `
	<div class="message"> <b>${message.userName}</b>: ${message.messageText}</div>
`

document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		sendMessage();
	}
});