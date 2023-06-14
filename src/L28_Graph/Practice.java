package L28_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Practice {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Practice() {
		this.vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		if (vtx == null) {
			return;
		}

		// neighbors of vname
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {
			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);
	}

	public int numEdges() {

		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());

		int count = 0;
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			count += vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {

		ArrayList<String> keys = new ArrayList<String>(this.vtces.keySet());

		System.out.println("--------------------------");
		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		System.out.println("--------------------------");

	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vtces.get(src);

		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}
		return false;
	}

	public class Pair {

		String vname;
		String psf;

		Pair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();

		q.addLast(new Pair(src, src));

		while (!q.isEmpty()) {

			Pair rp = q.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			if (this.containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			Vertex rpvtx = vtces.get(rp.vname);

			ArrayList<String> keys = new ArrayList<String>(rpvtx.nbrs.keySet());

			for (String key : keys) {
				if (!processed.containsKey(key))
					q.addLast(new Pair(key, rp.psf + key));
			}
		}

		return false;

	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> q = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			q.addLast(new Pair(key, key));
			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				System.out.println(rp.vname + " via " + rp.psf);
				ArrayList<String> nbrs = new ArrayList<String>(vtces.get(rp.vname).nbrs.keySet());
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						q.addLast(new Pair(nbr, rp.psf + nbr));
					}
				}
			}
		}
	}
	
	
}
