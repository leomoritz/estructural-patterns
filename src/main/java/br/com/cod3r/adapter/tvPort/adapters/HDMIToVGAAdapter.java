package br.com.cod3r.adapter.tvPort.adapters;

import br.com.cod3r.adapter.tvPort.intefaces.HDMI;
import br.com.cod3r.adapter.tvPort.intefaces.VGA;

public class HDMIToVGAAdapter implements HDMI {

    private final VGA vga;

    public HDMIToVGAAdapter(VGA vga) {
        System.out.println("Connecting the HDMI/VGA adapter...");
        this.vga = vga;
    }

    @Override
    public void setImage(String image) {
        System.out.println("Converting the image from HDMI to VGA via an adapter.");
        vga.setImage(image);
    }

    @Override
    public void setSound(String sound) {
        System.out.println("Sorry! The VGA connection does not support sound feature");
    }
}
