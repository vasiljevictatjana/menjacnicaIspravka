package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {
	
	private LinkedList<Kurs> kursevi = 
			new LinkedList<Kurs>();

	public void dodajKurs(Kurs kurs) {
		
		if(kurs.getDatumKursa().before(new GregorianCalendar(GregorianCalendar.YEAR, GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH)))
			throw new RuntimeException("Datum ne sme biti u proslosti!");
	

		if (kursevi.contains(kurs))
			throw new RuntimeException("Kurs vec postoji!");
		
		kursevi.add(kurs);


	}

	public void obrisiKurs(Kurs kurs) {
		
		if (!kursevi.contains(kurs))
			throw new RuntimeException("Kurs ne postoji!");
		
		kursevi.remove(kurs);
		
	}

	public LinkedList<Kurs> pronadjiKurs(GregorianCalendar datumKursa,
			double prodajniKurs, double kupovniKurs, double srednjiKurs,
			Valuta valuta) {
		
		LinkedList<Kurs> pronadjeniKursevi = 
				new LinkedList<Kurs>();
		
		if (datumKursa==null && prodajniKurs<=0 && kupovniKurs<=0 && srednjiKurs<=0)
			throw new RuntimeException("Mora biti unet neki kriterijum!");
		
		if (!datumKursa.after(new GregorianCalendar(GregorianCalendar.YEAR, GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH)))
			for (int i=0;i<kursevi.size();i++)
				if (kursevi.get(i).getDatumKursa()==datumKursa)
					pronadjeniKursevi.add(kursevi.get(i));
		

		
		return pronadjeniKursevi;
	}

}
