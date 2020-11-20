  
package common.file;

public class FileManager {

	//���ϸ� ���ϱ� : �Ű������� ������ ��θ� �Ѱܹ޾� ���ϸ� �����Ѵ�
	public static String getFilename(String path) {
		int lastIndex = path.lastIndexOf("/"); //�������� ��ġ��  /�� �ε��� ���ϱ�!!
		return path.substring(lastIndex+1, path.length());
	}
	
	//Ȯ���� ���ϱ� : �Ű������� ���ϸ��� �Ѱܹ޾� Ȯ���ڴ� �����Ѵ�
	public static String getExtend(String filename) {
		String[] str = filename.split("\\."); //���� �������� ���ڿ� �и�.. �и��Ŀ��� �迭�� ��ȯ��!
		return str[1];//�ι�° ĭ�� Ȯ������
	}
	
	//Ȯ���� ���ϱ� ������Ʈ : ������ ���� �������� �����;� ������ ����..
	public static String getExtend2(String filename) {
		//������ ���� ��ġ ���ϱ�!!! lastIndexOf �޼��� ������� 
		int lastIndex = filename.lastIndexOf(".");
		
		//�������� ���� ���ں��� �����;� �ϹǷ� +1�� ���Ѵ�!!
		return filename.substring(lastIndex+1, filename.length());
	}
	
	
	//���� �׽�Ʈ�� ���� ���θ޼��带 Ǯ�����!! �׽�Ʈ �Ŀ� �ٽ� �ּ����� ��������
	public static void main(String[] args) {
		String filename = getFilename("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
		
	}

}


