package test.pcdemo;

public class Info {

	private String title;
	private String content;

	private boolean flag = false;

	public Info(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public synchronized void set(String title, String content) {
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setTitle(title);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content);
		flag = false;
		super.notify();
	}

	public synchronized void get() {
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this);
		flag = true;
		super.notify();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return this.getTitle() + " -> " + this.getContent();
	}

}
