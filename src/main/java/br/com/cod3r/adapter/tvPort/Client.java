package br.com.cod3r.adapter.tvPort;

import br.com.cod3r.adapter.tvPort.adapters.HDMIToOldMonitorAdapter;
import br.com.cod3r.adapter.tvPort.adapters.HDMIToVGAAdapter;
import br.com.cod3r.adapter.tvPort.devices.Computer;
import br.com.cod3r.adapter.tvPort.devices.OldMonitor;
import br.com.cod3r.adapter.tvPort.devices.TV;

public class Client {

	public static void main(String[] args) {
		Computer pc = new Computer();
		TV tv = new TV();
		pc.connectPort(tv);
		pc.sendImageAndSound("Cat and rainbow", "Nyan cat song");
		
		System.out.println("------ Monitor ----------");
		Computer pc2 = new Computer();
		OldMonitor oldMonitor = new OldMonitor();
		//pc2.connectPort(oldMonitor); // Não funcionará, porque este monitor não implementa um HDMI diretamente.
		pc2.connectPort(new HDMIToVGAAdapter(oldMonitor)); // Funcionará porque o adaptador implementa HDMI
		pc2.sendImageAndSound("Happy family", "Family singing a happy day song!");

		System.out.println("------ Monitor Class Adapter (alternative) ----------");
		// A ideia é a própria classe já servir como adapter
		Computer pc3 = new Computer();
		HDMIToOldMonitorAdapter monitorAdaptee = new HDMIToOldMonitorAdapter();
		pc3.connectPort(monitorAdaptee);
		pc3.sendImageAndSound("Happy family", "Family singing a happy day song!");
	}
}
