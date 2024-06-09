package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.UserService;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class ChannelController {
	
	 private final ChannelService channelService;
	 private final UserService userService;
	 private final MessageService messageService;
	    
	    @Autowired
	    public ChannelController(ChannelService channelService, UserService userService, MessageService messageService) {
	        this.channelService = channelService;
	        this.userService = userService;
	        this.messageService = messageService;
	    }

	    @GetMapping("/")
	    public String redirectToWelcomePage() {
	        return "redirect:/welcome";
	    }

		@GetMapping("/welcome")
		public String getWelcomePage(ModelMap model) {
			List<Channel> channels = channelService.findAll();
			model.put("channels", channels);
			model.put("channel", new Channel());

			return "welcome";
		}
		
	    
	    @PostMapping("/welcome/createChannel")
		public String createNewChannel(Channel channel) {
			channelService.save(channel);
			userService.saveUsersToChannel(channel);
			return "redirect:/welcome";
		}
	    
	    @GetMapping("/channels/{channelId}")
		public String getChannel(ModelMap model, @PathVariable Long channelId) {
	    	if (channelService.findById(channelId) == null) {
	            return "redirect:/welcome";
	        } else {
	            Channel channel = channelService.findById(channelId);
	            List<Message> messages = messageService.findMessagesByChannelId(channelId);
	            model.put("channel", channel);
	            model.put("messages", messages);
	            model.put("users", new User());
	            return "channel";
	        }
		}
	
}

