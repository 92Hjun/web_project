package vo;

public class ItemVO {
	private int itemNo;
	private int itemCategoryNo;
	private String itemViewSrc;
	private String itemName;
	private String itemSrc;
	private int itemCount;
	private int price;
	private String color;
	private String size;
	private int itemGroupNo;
	private String itemEtc;

	public ItemVO () {}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemCategoryNo() {
		return itemCategoryNo;
	}

	public void setItemCategoryNo(int itemCategoryNo) {
		this.itemCategoryNo = itemCategoryNo;
	}

	public String getItemViewSrc() {
		return itemViewSrc;
	}

	public void setItemViewSrc(String itemViewSrc) {
		this.itemViewSrc = itemViewSrc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSrc() {
		return itemSrc;
	}

	public void setItemSrc(String itemSrc) {
		this.itemSrc = itemSrc;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getItemGroupNo() {
		return itemGroupNo;
	}

	public void setItemGroupNo(int itemGroupNo) {
		this.itemGroupNo = itemGroupNo;
	}

	public String getItemEtc() {
		return itemEtc;
	}

	public void setItemEtc(String itemEtc) {
		this.itemEtc = itemEtc;
	}
}
