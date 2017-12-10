package lianbiao;
import dao.ItemsDAO;
import java.util.ArrayList;
import entity.Items ;
import entity.Reader;
import java.util.* ;
import java.text.*;

/**
 * �Զ����������
 * 
 * @author zjn
 *
 */
public class MyLink {
    Node head = null; // ͷ�ڵ�

    /**
     * �����еĽڵ㣬data����ڵ��ֵ��next��ָ����һ���ڵ������
     * 
     * @author zjn
     *
     */
    class Node {
        Node next = null;// �ڵ�����ã�ָ����һ���ڵ�
        int data;// �ڵ�Ķ��󣬼�����

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * �������в�������
     * 
     * @param d
     */
    public void addNode(int d) {
        Node newNode = new Node(d);// ʵ����һ���ڵ�
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode; //���¼����Ԫ�ش����ָ�룻
    }

    /**
     * 
     * @param index:ɾ����index���ڵ�
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head; //��ǰ�ڵ�
        Node curNode = preNode.next;   //��һ���ڵ�
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;  //��ǰ�ڵ�����ø���ǰһ�ڵ������
                return true;
            }
            preNode = curNode; //��һ�ڵ����
            curNode = curNode.next;  //����
            i++;
        }
        return false;
    }

    /**
     * 
     * @return ���ؽڵ㳤��
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * �ڲ�֪��ͷָ��������ɾ��ָ���ڵ�
     * 
     * @param n
     * @return
     */
    public boolean deleteNode11(Node n) {
        if (n == null || n.next == null)
            return false;
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("ɾ���ɹ���");
        return true;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    
    /**
     * ����
     * 
     * @return
     */
    public Node orderList() {
        Node nextNode = null;
        int tmp = 0;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    tmp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
    
    //���ҽڵ�
    public int getNode(int index) {

       /* if (index < 1 || index > length()) {
            return false;
        }*/
        /*if (index == 1) {
            head = head.next;
            return true;
        }*/
        int i = 1;
        if(index==0)
        	return head.data;
        
        Node preNode = head; //ǰһ���ڵ�                              �ӵڶ����ڵ㿪ʼ����
        Node curNode = preNode.next;   //��ǰ�ڵ�
        while (curNode != null) {
            if (i == index) {
                //preNode.next = curNode.next;  //��ǰ�ڵ�����ø���ǰһ�ڵ������
                return curNode.data;
            }
            preNode = curNode; //��һ�ڵ����
            curNode = curNode.next;  //����
            i++;
        }
        return 0;
    }

    

//���������    
    public static void main(String[] args) {
        MyLink linklist = new MyLink();
        
        ItemsDAO itemsDao = new ItemsDAO();
		//Items item = itemDao.getreaderinfo();
		ArrayList<Reader> list = itemsDao.getreaderinfo();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Reader item = list.get(i);
				linklist.addNode(item.getIdNumber());
				//System.out.println("linkLength:" + linklist.length());
				//System.out.println("head.data:" + linklist.head.data);
				//linklist.deleteNode(4);
				//System.out.println("After deleteNode(4):");
				//linklist.printList();
    }
			System.out.println("linkLength:" + linklist.length());
			linklist.printList();
			System.out.println();
			linklist.orderList();
			linklist.printList();
			//linklist.deleteNode(4);
			//linklist.printList();
      }
    }
}