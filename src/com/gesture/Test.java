package com.gesture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {
	

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String code = null;
		File file = new File("gesture.key");
		if (!file.exists()) {
			getGesture();
		}
		code = getHex(file);
		
		exec(code);
		
//		DrawPasswd d = new DrawPasswd(null);
		
		
	}

	private static boolean equal(byte[] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(i == j) {
					continue;
				}
				if(b[i] == b[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static void exec(String code) throws NoSuchAlgorithmException {
		byte[] list = {0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08};
		
		List<Thread> threads = new ArrayList<Thread>();
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								
								byte[] tmp = new byte[4];
								tmp[0] = a;
								tmp[1] = b;
								tmp[2] = c;
								tmp[3] = d;
								
								if(equal(tmp)) {
									continue;
								}
								
								MessageDigest sha = null;
								try {
									sha = MessageDigest.getInstance("SHA-1");
								} catch (NoSuchAlgorithmException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								sha.update(tmp);
								String ss = getHex(sha.digest());
								System.out.println(this.getName() +" " +  ss);
								if(ss.equals(code)) {
									System.out.println(String.format("password is: %d %d %d %d", a, b, c, d));
									new DrawPasswd(tmp);
									
									for(Thread t : threads) {
										t.interrupt();
									}
								
									return;
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		thread = new Thread() {
			@Override
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								for(byte e : list) {
									byte[] tmp = new byte[5];
									tmp[0] = a;
									tmp[1] = b;
									tmp[2] = c;
									tmp[3] = d;
									tmp[4] = e;
									if(equal(tmp)) {
										continue;
									}
									MessageDigest sha = null;
									try {
										sha = MessageDigest.getInstance("SHA-1");
									} catch (NoSuchAlgorithmException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									sha.update(tmp);
									String ss = getHex(sha.digest());
									System.out.println(this.getName() +" " + ss);
									if(ss.equals(code)) {
										System.out.println(String.format("password is: %d %d %d %d %d", a, b, c, d, e));
										new DrawPasswd(tmp);
										for(Thread t : threads) {
											t.interrupt();
										}
										return;
									}
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		thread = new Thread() {
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								for(byte e : list) {
									for(byte f : list) {
										byte[] tmp = new byte[6];
										tmp[0] = a;
										tmp[1] = b;
										tmp[2] = c;
										tmp[3] = d;
										tmp[4] = e;
										tmp[5] = f;
										if(equal(tmp)) {
											continue;
										}
										MessageDigest sha = null;
										try {
											sha = MessageDigest.getInstance("SHA-1");
										} catch (NoSuchAlgorithmException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										sha.update(tmp);
										String ss = getHex(sha.digest());
										System.out.println(this.getName() +" " + ss);
										if(ss.equals(code)) {
											System.out.println(String.format("password is: %d %d %d %d %d %d", a, b, c, d, e, f));
											new DrawPasswd(tmp);
											for(Thread t : threads) {
												t.interrupt();
											}
											return;
										}
									}
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		thread = new Thread() {
			@Override
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								for(byte e : list) {
									for(byte f : list) {
										for(byte g : list) {
											byte[] tmp = new byte[7];
											tmp[0] = a;
											tmp[1] = b;
											tmp[2] = c;
											tmp[3] = d;
											tmp[4] = e;
											tmp[5] = f;
											tmp[6] = g;
											if(equal(tmp)) {
												continue;
											}
											MessageDigest sha = null;
											try {
												sha = MessageDigest.getInstance("SHA-1");
											} catch (NoSuchAlgorithmException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											sha.update(tmp);
											String ss = getHex(sha.digest());
											System.out.println(this.getName() +" " + ss);
											if(ss.equals(code)) {
												System.out.println(String.format("password is: %d %d %d %d %d %d %d", a, b, c, d, e, f, g));
												new DrawPasswd(tmp);
												for(Thread t : threads) {
													t.interrupt();
												}
												return;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		thread = new Thread() {
			@Override
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								for(byte e : list) {
									for(byte f : list) {
										for(byte g : list) {
											for(byte h : list) {
												byte[] tmp = new byte[8];
												tmp[0] = a;
												tmp[1] = b;
												tmp[2] = c;
												tmp[3] = d;
												tmp[4] = e;
												tmp[5] = f;
												tmp[6] = g;
												tmp[7] = h;
												if(equal(tmp)) {
													continue;
												}
												MessageDigest sha = null;
												try {
													sha = MessageDigest.getInstance("SHA-1");
												} catch (NoSuchAlgorithmException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												sha.update(tmp);
												String ss = getHex(sha.digest());
												System.out.println(this.getName() +" " + ss);
												if(ss.equals(code)) {
													System.out.println(String.format("password is: %d %d %d %d %d %d %d %d", a, b, c, d, e, f, g, h));
													new DrawPasswd(tmp);
													for(Thread t : threads) {
														t.interrupt();
													}
													return;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		
		thread = new Thread(){
			@Override
			public void run() {
				for(byte a : list) {
					for(byte b: list) {
						for(byte c : list) {
							for(byte d : list) {
								for(byte e : list) {
									for(byte f : list) {
										for(byte g : list) {
											for(byte h : list) {
												for(byte i : list) {
													byte[] tmp = new byte[8];
													tmp[0] = a;
													tmp[1] = b;
													tmp[2] = c;
													tmp[3] = d;
													tmp[4] = e;
													tmp[5] = f;
													tmp[6] = g;
													tmp[7] = h;
													tmp[7] = i;
													if(equal(tmp)) {
														continue;
													}
													MessageDigest sha = null;
													try {
														sha = MessageDigest.getInstance("SHA-1");
													} catch (NoSuchAlgorithmException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
													sha.update(tmp);
													String ss = getHex(sha.digest());
													System.out.println(this.getName() +" " + ss);
													if(ss.equals(code)) {
														System.out.println(String.format("password is: %d %d %d %d %d %d %d %d %d", a, b, c, d, e, f, g, h, i));
														new DrawPasswd(tmp);
														for(Thread t : threads) {
															t.interrupt();
														}
														return;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		};
		threads.add(thread);
		
		for(Thread t : threads) {
			t.start();
		}
		
	}

	public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
	private static String getHex(byte[] buff) {
		
		StringBuilder sb = new StringBuilder();
		for(byte b : buff) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	private static String getHex(File file) {
		StringBuilder sb = new StringBuilder();
		try {
			
			FileInputStream in = new FileInputStream(file);
			byte[] buff = new byte[(int) file.length()];
			in.read(buff);
			for(byte b : buff) {
				sb.append(String.format("%02x", b));
			}
			System.out.println(sb.toString());
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static void getGesture() {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		
		String s = "adb pull /data/system/gesture.key gesture.key";
		
		try {
			process = runtime.exec(s);
			process.waitFor();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
