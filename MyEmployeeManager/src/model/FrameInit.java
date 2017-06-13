package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

//Frame的大小设置，及在显示器的位置
public class FrameInit{
	public static void InitFrame(JFrame f,JPanel p){
		f.add(p,BorderLayout.CENTER);
		f.pack();//？
		f.setSize(new Dimension(500,400));
		
		//设置frame的大小，及在显示器的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取显示器的尺寸
		Dimension frameSize=f.getSize();
		if(frameSize.height>screenSize.height){
			frameSize.height=screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width=screenSize.width;
		}
		f.setLocation((screenSize.width-frameSize.width)/2,
						(screenSize.height-frameSize.height)/2);
		p.setLayout(new BorderLayout());
	}
}
