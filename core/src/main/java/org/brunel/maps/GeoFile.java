package org.brunel.maps;

/**
 * Keeps basic information on a geo file
 */
class GeoFile implements Comparable<GeoFile> {
    public final String name;           // File name
    public final int index;             // index within the global list of files
    public final double size;           // Size in Kbytes
    public final Rect bounds;           // longitude min, max; latitude min,max

    public GeoFile(String name, int index, String boundsString, String sizeString) {
        this.name = name;
        this.index = index;
        this.size = Integer.parseInt(sizeString);
        String[] b = boundsString.split(",");
        this.bounds = new Rect(Double.parseDouble(b[0]), Double.parseDouble(b[1]), Double.parseDouble(b[2]), Double.parseDouble(b[3]));
    }

    public int compareTo(GeoFile o) {
        return name.compareTo(o.name);
    }

    public boolean covers(double x, double y) {
        return bounds.contains(x,y);
    }

    public String toString() {
        return name;
    }
}
