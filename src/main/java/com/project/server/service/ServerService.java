package com.project.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.server.entity.ServerInfo;
import com.project.server.exception.ServerNotFound;
import com.project.server.repository.ServerRepo;

@Service
public class ServerService {

	@Autowired
	private ServerRepo serverrepo;

	public ServerInfo getServerDetailById(Integer id) throws ServerNotFound {
		Optional<ServerInfo> info = serverrepo.findById(id);
		if (info.isPresent())
			return info.get();
		else
			throw new ServerNotFound("Not Found Server");
	}

	public List<ServerInfo> getAllServersDetails() {
		List<ServerInfo> lst = serverrepo.findAll();
		return lst;
	}

	public void addNewServer(ServerInfo serverinfo) {
		serverrepo.save(serverinfo);
	}

	public List<ServerInfo> getServerDetailByName(String name) throws ServerNotFound {
		List<ServerInfo> list = serverrepo.getByName(name);
		if (list.isEmpty()) {
			throw new ServerNotFound("Not Found Server");
		}
		return list;
	}

	public void deleteById(Integer id) throws ServerNotFound {
		ServerInfo server = serverrepo.findById(id)
				.orElseThrow(() -> new ServerNotFound("Server details not found for Id: " + id));
		serverrepo.delete(server);
	}

	public ServerInfo updateServer(ServerInfo serverInfo, Integer id) {
		return serverrepo.findById(id).map(server -> {
			server.setName(serverInfo.getName());
			server.setLanguage(serverInfo.getLanguage());
			server.setFramework(serverInfo.getFramework());
			return serverrepo.save(server);
		}).orElseGet(() -> {
			return serverrepo.save(serverInfo);
		});
	}
}
