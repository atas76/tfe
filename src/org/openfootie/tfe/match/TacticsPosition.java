package org.openfootie.tfe.match;

public class TacticsPosition implements Comparable {

	private LinePosition linePosition;
	private Position position;
	
	public TacticsPosition(LinePosition linePosition, Position position) {
		this.linePosition = linePosition;
		this.position = position;
	}
	
	public LinePosition getLinePosition() {
		return this.linePosition;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public int compareTo(Object obj) {
		
		TacticsPosition tacticsPosition = (TacticsPosition) obj;
		
		if (this.linePosition.ordinal() != tacticsPosition.linePosition.ordinal()) {
			return this.linePosition.ordinal() - tacticsPosition.linePosition.ordinal();
		} else {
			if (tacticsPosition.position != null) {
				return this.position.ordinal() - tacticsPosition.position.ordinal();
			}
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return linePosition.toString() + (position != null ? " " + position.toString(): "");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linePosition == null) ? 0 : linePosition.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacticsPosition other = (TacticsPosition) obj;
		if (linePosition != other.linePosition)
			return false;
		if (position != other.position)
			return false;
		return true;
	}
}
