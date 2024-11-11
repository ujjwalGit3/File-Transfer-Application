import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class aaa extends Thread
{
private SomeFrame sf;
aaa(SomeFrame e)
{
this.sf=e;
}
public void run()
{
for(int i=1; i<=500; i++)
{
sf.updateNum(i);
}
}
}
class SomeFrame extends JFrame implements ActionListener
{
private JTextArea jta;
private JButton button;
private JProgressBar pb;
SomeFrame()
{
Container container=getContentPane();
container.setLayout(new BorderLayout());
jta=new JTextArea();
button=new JButton("Start");
pb=new JProgressBar(1,500);
button.addActionListener(this);

container.add(jta,BorderLayout.CENTER);
container.add(button,BorderLayout.SOUTH);
container.add(pb,BorderLayout.NORTH);
setLocation(100,100);
setSize(400,400);
setVisible(true);
}
public void updateNum(int i)
{
jta.append(i+" ");
if(i%10==0) jta.append("\n");
pb.setValue(i);
}
public void actionPerformed(ActionEvent e)
{
SwingUtilities.invokeLater(new aaa(this));
}
public static void main(String gg[])
{
SomeFrame d=new SomeFrame();
}
}