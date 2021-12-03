package View;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SysInfo;
import org.hyperic.sigar.Swap;


import org.hyperic.sigar.SigarException;
class SistemaInfo {

public static void main(String[] args) {

try {
Sigar info = new Sigar();
Mem memoria = new Mem();
Swap swap = new Swap();
swap.gather(info);
SysInfo sys = new SysInfo();
sys.gather(info);
memoria.gather(info);

System.out.printf("Arquitetura:" + sys.getArch() + "\n");
System.out.printf("Descrição:" + sys.getDescription() + "\n");
System.out.printf("Maquina:" + sys.getMachine() + "\n");
System.out.printf("Nome:" + sys.getName() + "\n");
System.out.printf("Patch:" + sys.getPatchLevel()+ "\n");
System.out.printf("Vendedor:" + sys.getVendor()+ "\n");
System.out.printf("Vendedor (Cod nome):" + sys.getVendorCodeName() + "\n");
System.out.printf("Vendedor (Nome):" + sys.getVendorName() + "\n");
System.out.printf("Vendedor (Versão):" + sys.getVendorVersion() + "\n");
System.out.printf("Versão:" + sys.getVersion() + "\n\n");


System.out.printf("Mwmoria Total:" + memoria.getTotal() / 1024 / 1024 + "\n");
System.out.printf("Memoria Utilizada:" + memoria.getUsed() / 1024 / 1024 + "\n");
System.out.printf("Memoria Livre:" + memoria.getFree() / 1024 / 1024 + "\n\n");

System.out.printf("Memoria Swap Total:" + swap.getTotal() / 1024 / 1024 + "\n");
System.out.printf("Memoria Swap Utilizada:" + swap.getUsed() / 1024 / 1024 + "\n");
System.out.printf("Memoria Swap Livre:" + swap.getFree() / 1024 / 1024 + "\n");

} catch(SigarException e) {
	System.out.println(e);
	}
	
 }
 
}