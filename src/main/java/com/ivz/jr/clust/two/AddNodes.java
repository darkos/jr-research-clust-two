package com.ivz.jr.clust.two;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;

import org.apache.jackrabbit.commons.JcrUtils;

public class AddNodes {

	public static void main(String[] args) throws LoginException, RepositoryException {
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));

		try {
			Workspace workspace = session.getWorkspace();
			workspace.createWorkspace("knowledge");

			Session session1 = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "knowledge");

			Node root = session1.getRootNode();
			Node home = root.addNode("doctrina");
			// Node knowledge = home.addNode("knowledge");
			// Node users = home.addNode("users");
			// Node subjects = home.addNode("subjects");
			// Node interest = home.addNode("interest");
			// Node tools = home.addNode("tools");
			session1.save();
			session1.logout();
		} finally {
			session.logout();
		}
	}

}
