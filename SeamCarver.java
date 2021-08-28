package seamcarver;
import java.awt.List;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

public class SeamCarver {
	Picture picture;
	int height;
	int width;
	public SeamCarver(Picture pic) {
		picture = pic;
		height = picture.height();
		width = picture.width();
	}
	
	public Picture picture() {
		return picture;
	}
	
	public int width() {
		return width;
	}
	public int height() {
		return height;
	}
	
	public int[] getColors(int x, int y) {
		int rgb = picture.getRGB(x-1, y);
		int[] col = {(rgb >> 16) & 0xFF, (rgb >>  8) & 0xFF, (rgb >>  0) & 0xFF};
		return col;
	}
	
	public double energy(int x, int y) {
		double energy = 0;
		int[] x1 = getColors(x-1, y);
		int[] x2 = getColors(x+1, y);
		int[] y1 = getColors(x, y-1);
		int[] y2 = getColors(x, y+1);
		
		for (int i = 0; i < x1.length; i++) {
			energy += Math.pow(x2[i]-x1[i], 2) + Math.pow(y2[i]-y1[i], 2);
		}
		
		
		return Math.sqrt(energy);
	}
	
	public boolean inDistTo(int dimension1, int dimension2, ArrayList<int[]> distTo, int[] v1, ArrayList<Double> distance, ArrayList<int[]> edgeTo) {
		boolean flag = false;
		if (!distTo.contains(v1) && v1[0]<dimension1 && v1[1] < dimension2) {
			distTo.add(v1);
			distance.add(null);
			edgeTo.add(null);
			flag = !flag;
		}
		return flag;
	}

	public ArrayList<int[]> shortestPathDAG(int dimension1, int dimension2) {
		ArrayList<int[]> distTo= new ArrayList<int[]>();
		ArrayList<Double> distance = new ArrayList<Double>();
		ArrayList<int[]> edgeTo= new ArrayList<int[]>();
		int[] pixel = {1,1};
		distTo.add(pixel);
		distance.add(energy(pixel[0], pixel[1])+1000);
		double dis;
		double shortestDis = (Double) null;
		int[] shortestPixel = null ;
		while (distTo.hasMoreElements()) {
			pixel = distTo.nextElement();
			int[] v1 = {pixel[0]+1,pixel[1]};
			int[] v2 = {pixel[0],pixel[1]+1};
			if (inDistTo(dimension1, dimension2, distTo, v1, distance, edgeTo)) {
				if (distance.get(distance.size()) == null || distance.get(distance.size()) < distance.get(distTo.indexOf(pixel))+energy(v1[0], v1[1])) {
					distance.set(distance.size(), distance.get(distTo.indexOf(pixel))+energy(v1[0], v1[1]));
					edgeTo.set(edgeTo.size(),pixel);
				}
				if(distance.get(distance.size())<shortestDis && pixel[1]==dimension2) {
					shortestPixel = pixel;
					shortestDis= distance.get(distance.size());
				}
				
			}
			if(inDistTo(dimension1, dimension2, distTo, v2, distance, edgeTo)) {
				if (distance.get(distance.size()) == null || distance.get(distance.size()) < distance.get(distTo.indexOf(pixel))+energy(v2[0], v2[1])) {
					distance.set(distance.size(), distance.get(distTo.indexOf(pixel))+energy(v2[0], v2[1]));
					edgeTo.set(edgeTo.size(),pixel);
				}
			}
	
		}
		
		int[] edgeToShortest = edgeTo.get(distTo.indexOf(shortestPixel));
		ArrayList<int[]> edges = new ArrayList<int[]>();
		while (edgeToShortest[1]!=1) {
			edges.add(edgeToShortest);
			edgeToShortest = edgeTo.get(distTo.indexOf(edgeToShortest));
		}

		
		return edges;
	}
		
	
	
	   public ArrayList<int[]> findHorizontalSeam() {
		   return shortestPathDAG(height, width);
		   
	   }
	   public ArrayList<int[]> findVerticalSeam(){
		   return shortestPathDAG(width, height);
	   }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
