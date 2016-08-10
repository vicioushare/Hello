package com.vicioushare.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

import org.junit.Test;

public class PackageTest {
	@Test
	public void packageTest() {
		try {
			JpcapCaptor jpcap;
			NetworkInterface[] devices = JpcapCaptor.getDeviceList();
			printNetDeviceInfo(devices[2]);
			jpcap = JpcapCaptor.openDevice(devices[2], 2000, true, 20);
			// jpcap.setFilter("host 116.116.116.116", true);
			// jpcap.setFilter("ip", true);
			while (true) {
				analyseTcpPackage(jpcap.getPacket());
				// analysePackage(jpcap.getPacket());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 分析包
	 * 
	 * @param p
	 */
	public void analysePackage(Packet p) {
		if (p instanceof ARPPacket) {
			System.out.println("---ARPPacket------");
			ARPPacket arpPacket = (ARPPacket) p;
			System.out.println("\n" + arpPacket + "\n");
		} else if (p instanceof ICMPPacket) {
			System.out.println("---ICMPPacket-------");
			ICMPPacket arpPacket = (ICMPPacket) p;
			System.out.println("\n" + arpPacket + "\n");
		} else if (p instanceof TCPPacket) {
			System.out.println("---TCP-------");
			TCPPacket tcpPacket = (TCPPacket) p;
			// System.out.println("\n" + tcpPacket + "\n");
			EthernetPacket ethernetPacket = (EthernetPacket) p.datalink;
			System.out.print("源IP：" + tcpPacket.src_ip + "目的IP：" + tcpPacket.dst_ip + "发送端口：" + tcpPacket.src_port
					+ "接收端口：" + tcpPacket.dst_port + "\n");
			System.out.print("源MAC：" + ethernetPacket.getSourceAddress() + "目的MAC："
					+ ethernetPacket.getDestinationAddress() + "\n");
			System.out.print("协议：" + tcpPacket.protocol + "\n");
			System.out.print("数据：[");
			System.out.println("---------");
			System.out.println(charToString(tcpPacket.data));
			System.out.println("---------");
			for (int i = 0; i < tcpPacket.data.length; i++) {
				System.out.print((char) tcpPacket.data[i]);
			}
			System.out.print("] 数据");
			System.out.println();
		} else if (p instanceof UDPPacket) {
			System.out.println("---UDP-------");
			UDPPacket udpPacket = (UDPPacket) p;
			EthernetPacket ethernetPacket = (EthernetPacket) p.datalink;
			System.out.print("源IP：" + udpPacket.src_ip + "目的IP：" + udpPacket.dst_ip + "发送端口：" + udpPacket.src_port
					+ "接收端口：" + udpPacket.dst_port + "\n");
			System.out.print("源MAC：" + ethernetPacket.getSourceAddress() + "目的MAC："
					+ ethernetPacket.getDestinationAddress() + "\n");
			System.out.print("协议：" + udpPacket.protocol + "\n");
			System.out.print("数据：[ ");
			for (int i = 0; i < udpPacket.data.length; i++) {
				System.out.print((char) udpPacket.data[i]);
			}
			System.out.print("] 数据");
			System.out.println();
		} else if (null != p) {
			System.out.println("---开始-------");
			String data = new String(p.data);
			System.out.println(data);
			System.out.println("---byte-------");
			byte[] by = p.data;
			for (byte b : by) {
				System.out.print(Integer.toHexString(b & 0xff) + ":");
			}
			System.out.println("-----结束-----");
		}

	}

	public void analyseTcpPackage(Packet p) {
		if (p instanceof TCPPacket) {
			TCPPacket tcpPacket = (TCPPacket) p;
			// System.out.println("\n" + tcpPacket + "\n");
			EthernetPacket ethernetPacket = (EthernetPacket) p.datalink;
			String data = charToString(tcpPacket.data);
			if (data.contains("get") || data.contains("GET")) {
				System.out.println("---TCP-------");
				System.out.println("源IP：" + tcpPacket.src_ip + "目的IP：" + tcpPacket.dst_ip + "发送端口："
						+ tcpPacket.src_port + "接收端口：" + tcpPacket.dst_port);
				System.out.println("源MAC：" + ethernetPacket.getSourceAddress() + "目的MAC："
						+ ethernetPacket.getDestinationAddress());
				System.out.println("协议：" + tcpPacket.protocol);
				if (data.contains("get") || data.contains("GET")) {
					System.out.println("数据：[");
					System.out.println(data);
					System.out.println("] 数据");
				}

			}
		}
	}

	/**
	 * 打印网卡信息。
	 * 
	 * @param device
	 */
	public void printNetDeviceInfo(NetworkInterface device) {
		System.out.println(device.name + "(" + device.description + ")");
		System.out.println("    data link:" + device.datalink_name + "(" + device.datalink_description + ")");
		System.out.print("    MAC address:");
		for (byte b : device.mac_address) {
			System.out.print(Integer.toHexString(b & 0xff) + ":");
		}
		System.out.println();
		for (NetworkInterfaceAddress a : device.addresses) {
			System.out.println("    address:" + a.address + " " + a.subnet + " " + a.broadcast);
		}
	}

	public String charToString(byte[] chars) {
		try {
			DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(chars));
			String str = "";
			String returnStr = "";
			String encode = "utf-8";
			BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream, encode));
			StringBuffer sb = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				sb.append(str).append("\n");
			}
			returnStr = sb.toString();
			return returnStr;
		} catch (Exception e) {
			return null;
		}

	}

}
