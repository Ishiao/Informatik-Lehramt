import java.util.Arrays;

public class Measurement {

	private int[] data;

	public Measurement() {
		data = new int[0];
	}

	public void addValue(int value) {
		//neues Array wird erzeugt mit einer Länge vom Data Array +1
		//weiterer Platz um den neuen Wert anzuhängen
		int[] klon = new int[data.length+1];
		//wir gehen das Array Data durch und überschreiben die Plätze
		//also klonen wir das Array Data
		for(int i = 0;i<data.length;i++){
			klon[i] = data[i];
		}
		//nun fügen wir den wert an das Array Klon dran
		klon[data.length] = value;
		//Das Array Data kriegt die selben Werte von Klon
		//Dies tun wir, weil wir nicht den Klon ausgeben wollen
		//sondern das UrsprungsArray verändern wollten
		data = klon;
	}

	public void addValues(int[] values) {
		int[] klon = new int[data.length + values.length];
		for(int i=0; i<data.length; i++){
			klon[i] = data[i];
		}
		for(int i=0;i<values.length;i++){
			klon[data.length +i] = values[i];
		}
		data = klon;
	}

	public int getMinimumValue() {
		int kl = data[0];
		for(int i = 1; i<data.length; i++){
			if(kl>data[i]){
				kl = data[i];
			}
		}
		return kl;
	}

	public int[] getValuesAboveThreshold(int threshold) {
		int wert =0;
		for(int i = 0; i<data.length;i++){
			if(data[i]>threshold){
				wert = wert +1;
			}
		}
		int[] klon = new int[wert];

		for(int i =0, j=0; i< data.length;i++){
			if(data[i]>threshold){
				klon[j]= data[i];
				j++;
			}
		}
		return klon;
	}

	// --------------------------------------------------------------

	public void printData() {
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		Measurement m = new Measurement();
		System.out.println("Neues Measurement-Objekt m erzeugt. m:");
		// ErwarteteAusgabe:
		// []
		m.printData();

		System.out.println("------------------------------------------------------------------");

		m.addValue(85);
		System.out.println("Hinzufuegen eines neuen Wertes. m:");
		// Erwartete Ausgabe:
		// [85]
		m.printData();

		System.out.println("------------------------------------------------------------------");

		m.addValues(new int[] { 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93 });
		System.out.println("Hinzufuegen einer Menge von Werten. m:");
		// Erwartete Ausgabe:
		// [85, 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93]
		m.printData();

		System.out.println("------------------------------------------------------------------");

		int minimumValue = m.getMinimumValue();
		System.out.println("Minimaler Wert der Messreihe m:");
		// Erwartete Ausgabe: 58
		System.out.println(minimumValue);

		System.out.println("------------------------------------------------------------------");

		int[] valuesAbove78 = m.getValuesAboveThreshold(78);
		System.out.println("Messwerte ueber 78:");
		// Erwartete Ausgabe:
		// [85, 93, 81, 79, 81, 93]
		System.out.println(Arrays.toString(valuesAbove78));

		System.out.println("------------------------------------------------------------------");

		int[] valuesAbove93 = m.getValuesAboveThreshold(93);
		System.out.println("Messwerte ueber 93:");
		// Erwartete Ausgabe:
		// []
		System.out.println(Arrays.toString(valuesAbove93));
	}

}