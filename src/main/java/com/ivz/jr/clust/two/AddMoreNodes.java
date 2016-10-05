package com.ivz.jr.clust.two;

import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

public class AddMoreNodes {
	
	public static void main(String[] args) throws LoginException, NoSuchWorkspaceException, RepositoryException {
		
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "knowledge");
		
		try {
			Node home = session.getNode("/doctrina");
			System.out.println(home.getName());
//			Node knowledge = home.addNode("knowledge");
//			Node users = home.addNode("users");
//			Node subjects = home.addNode("subjects");
//			Node interest = home.addNode("interest");
        	Node tools = home.addNode("tools");
			session.save();
		} finally {
			session.logout();
		}
	}

}
