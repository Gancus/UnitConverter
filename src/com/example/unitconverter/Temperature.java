package com.example.unitconverter;

public class Temperature {
	
	private float cels;
	private float fahr;
	private float kelv;
	
	public float getCels() {
		return cels;
	}
	public void setCels(float cels) {
		this.cels = cels;
		refresh(1);
	}
	
	public float getFahr() {
		return fahr;
	}
	public void setFahr(float fahr) {
		this.fahr = fahr;
		refresh(2);
	}
	
	public float getKelv() {
		return kelv;
	}
	public void setKelv(float kelv) {
		this.kelv = kelv;
		refresh(3);
	}
	
	private void refresh(int number) {
		/** Number:
		 * 1 - Celsius
		 * 2 - Fahrenheit
		 * 3 - Kelvin
		 */
		switch(number) {
		case 1: {
				fahr = 32 + (((float)9/(float)5) * cels);
				kelv = (float) (cels + 273.15);
				break;
			}
		case 2: {
				cels = ((float)5/(float)9) * (fahr - 32);
				kelv = (float) (cels + 273.15);
				break;
			}
		case 3: {
				cels = (float) (kelv - 273.15);
				fahr = 32 + (((float)9/(float)5) * cels);
				break;
			}
		}
	}

}
