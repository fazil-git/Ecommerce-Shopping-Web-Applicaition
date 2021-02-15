package dao;

import java.util.List;

import dto.ItemDTO;

public abstract class ItemDAO {
	public abstract List<ItemDTO> displayItems(String shopid);
}
