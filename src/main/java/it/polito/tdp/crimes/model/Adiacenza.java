package it.polito.tdp.crimes.model;

import java.util.Objects;

public class Adiacenza {
 String r1;
 String r2;
 int peso;
public String getR1() {
	return r1;
}
public void setR1(String r1) {
	this.r1 = r1;
}
public String getR2() {
	return r2;
}
public void setR2(String r2) {
	this.r2 = r2;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}
@Override
public int hashCode() {
	return Objects.hash(r1, r2);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Adiacenza other = (Adiacenza) obj;
	return Objects.equals(r1, other.r1) && Objects.equals(r2, other.r2);
}
public Adiacenza(String r1, String r2, int peso) {
	super();
	this.r1 = r1;
	this.r2 = r2;
	this.peso = peso;
}
 

}
