package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.coderscampus.assignment14.domain.Channel;
//import com.coderscampus.assignment14.domain.User;
//import com.coderscampus.assignment14.dto.MessageDto;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.UserService;


@Controller
public class ChannelController {
	
	 private final ChannelService channelService;
	 private final UserService userService;
	    
	    @Autowired
	    public ChannelController(ChannelService channelService, UserService userService) {
	        this.channelService = channelService;
	        this.userService = userService;
	    }

	    @GetMapping("/")
	    public String redirectToWelcomePage() {
	        return "redirect:/welcome";
	    }

	    @GetMapping("/welcome")
	    public String getWelcomePage(ModelMap model)  {
	      
	            List<Channel> channels = channelService.findAll();
	            model.put("channels", channels);
	            model.put("channel", new Channel());
	        
	        return "welcome";
	    }
	    
	    @PostMapping("/welcome/createChannel")
		public String createNewChannel(Channel channel) {
			channelService.save(channel);
			return "redirect:/welcome";
		}
	    
	    @GetMapping("/channels/{channelId}")
		public String getChannel(ModelMap model, @PathVariable Long channelId) {
	    	Channel channel = channelService.findByChannelId(channelId);
	    	model.put("channels", channelService.findAll());
	    	model.put("channel", channel);
	    	model.put("users", userService.findAll());
	    	return "channel";
	    	
		}
	
}

