package com.ivz.jr.clust.two;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

public class ReadNodes {

	public static void main(String[] args) throws RepositoryException {
		
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "knowledge");
		
		Node root = session.getRootNode();
		NodeIterator nodeIterator = root.getNodes();
		while(nodeIterator.hasNext()) {
			Node n = nodeIterator.nextNode();
			System.out.println(n.getName() + ":" + n.getPath() + ", type:" +n.getPrimaryNodeType().getName());
		}
		
		Node home = session.getNode("/doctrina");
		NodeIterator homeNodes = home.getNodes();
		while(homeNodes.hasNext()) {
			System.out.println(homeNodes.nextNode().getName());
		}
		
		session.logout();
	}
	
}
