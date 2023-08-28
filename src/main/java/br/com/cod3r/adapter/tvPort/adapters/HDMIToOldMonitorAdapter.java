package br.com.cod3r.adapter.tvPort.adapters;

import br.com.cod3r.adapter.tvPort.devices.OldMonitor;
import br.com.cod3r.adapter.tvPort.intefaces.HDMI;

public class HDMIToOldMonitorAdapter extends OldMonitor implements HDMI {

    public HDMIToOldMonitorAdapter() {
        super();
        System.out.println("Wrapping the VGA's OldMonitor's Inteface with HDMI class adapter");
    }

    @Override
    public void setImage(String image) {
        System.out.println("Converting the image from VGA to HDMI via an class adapter.");
        super.setImage(image);
    }

    @Override
    public void setSound(String sound) {
        System.out.println("Sorry! The VGA connection does not support sound feature");
    }
}
