package interfejs;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.Kurs;
import menjacnica.Valuta;

public interface MenjacnicaInterfejs {

	public void dodajKurs(Kurs kurs);
	public void obrisiKurs(Kurs kurs);
	public LinkedList<Kurs> pronadjiKurs(GregorianCalendar datumKursa, double prodajniKurs, double kupovniKurs, double srednjiKurs, Valuta valuta);
	
}
