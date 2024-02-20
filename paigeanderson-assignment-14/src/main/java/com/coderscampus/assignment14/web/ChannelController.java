package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.ChannelService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping("/")
	public String directToWelcome() {
		return "redirect:/welcome";
	}

	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {

		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		model.put("channel", new Channel());

		return "welcome";
	}

	@GetMapping("/channels/{channelId}")
	public String getOneChannel(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findByChannelId(channelId);
		model.put("channel", channel);
		model.put("messages", new Message());
		return "channel";
	}
	
	@PostMapping("/welcome/createChannel")
	public String createNewChannel(String channelName, ModelMap model) {
		Channel newChannel = channelService.createNewChannel(channelName);
		if (newChannel == null) {
			model.addAttribute("channelCreationError", true);
		} else {
			model.addAttribute("newChannel", newChannel);
		}
		channelService.saveChannel(newChannel);
		return "redirect:/welcome";
	}


	
}

