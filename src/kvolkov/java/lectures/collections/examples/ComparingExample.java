package kvolkov.java.lectures.collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ComparingExample {
	
	static class Point3D implements Comparable<Point3D> {
		float x;
		float y;
		float z;
		
		Point3D(float x, float y, float z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Point3D other) {
//			if (this.x == other.x
//					&& this.y == other.y
//					&& this.z == other.z) {
				return -1;
//			} else {
//				float thisLen = this.x * this.x + this.y * this.y + this.z * this.z;
//				float otherLen = other.x * other.x + other.y * other.y + other.z * other.z;
//				
//				return thisLen > otherLen ? 1 : -1;
//			}
		}
		
		@Override
		public String toString() {
			float thisLen = this.x * this.x + this.y * this.y + this.z * this.z;
			return "length = " + thisLen;
		}
		
		public int hashCode() {
			return Float.valueOf(x).hashCode() * 31
					+ Float.valueOf(y).hashCode() * 31
					+ Float.valueOf(z).hashCode() * 31;
		}
	}
	
	public static void run() {
		Point3D point1 = new Point3D(1.5f, 2.5f, 3.5f);
		Point3D point2 = new Point3D(2.5f, 2.5f, 3.5f);
		Point3D point3 = new Point3D(1.5f, 1.5f, 3.5f);
		
		List<Point3D> list = new ArrayList();
		list.add(point1);
		list.add(point2);
		list.add(point3);
		
		Collections.sort(list);
		
		for (Point3D pt : list) {
			System.out.println(pt);
		}

		Collections.sort(list, new Comparator<Point3D>() {
			@Override
			public int compare(Point3D o1, Point3D o2) {
				if (o1.x == o2.x
						&& o1.y == o2.y
						&& o1.z == o2.z) {
					return 0;
				} else {
					float thisLen = o1.x * o1.x + o1.y * o1.y + o1.z * o1.z;
					float otherLen = o2.x * o2.x + o2.y * o2.y + o2.z * o2.z;
					
					return thisLen < otherLen ? 1 : -1;
				}
			}	
		});
		for (Point3D pt : list) {
			System.out.println(pt);
		}
		
		System.out.println("Max element:");
		System.out.println(Collections.max(list));
		
		Set<Point3D> set = new TreeSet();
		Random random = new Random();
		for (int i = 0; i < 100; ++i) {
			set.add(new Point3D(random.nextFloat(),
								random.nextFloat(),
								random.nextFloat()));
		}
		System.out.println("");
		System.out.println("");
		System.out.println("SET <<<<<<");
		System.out.println("");
		for (Point3D pt : set) {
			System.out.println(pt);
		}
	}

}