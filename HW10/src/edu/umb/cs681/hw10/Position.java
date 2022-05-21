package edu.umb.cs681.hw10;

public final class Position {
	private final double lat, longitude, altitude;
	public Position(double lat, double lon, double alt) {
		this.lat = lat;
		this.longitude = lon;
		this.altitude = alt;
	}
	public double getLatitude() {
		return lat;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getAltitude() {
		return altitude;
	}
	public String toString(){
		return "(" +lat + " , " + longitude + " , " + altitude + ")";
	}
	public boolean equals(Position pos) {
		if(this.toString().equals(pos.toString())) {
			return true;
		}else {
			return false;
		}
	}
	public Position changeLat(double newLat) {
		return new Position(newLat, this.longitude, this.altitude);
	}
	
	public Position changeLong(double newLong) {
		return new Position(this.lat, newLong, this.altitude);
	}
	
	public Position changeAlt(double newAlt) {
		return new Position(this.lat, this.longitude, newAlt);
	}

}
