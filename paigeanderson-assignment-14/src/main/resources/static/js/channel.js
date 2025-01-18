const messageInput = document.getElementById('message-input');
const chatMessages = document.querySelector('.chat-messages');
const queryString = window.location.href;
const channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
const user = sessionStorage.getItem('username');

console.log(user, channelId);

