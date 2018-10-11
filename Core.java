package j8.kotcmm;

public class Core {

	private int data[][];

	private int x;

	private int y;

	private boolean isGameOver;


	public Core(int x, int y) {

		this.data = new int[y][x];
		this.x = x;
		this.y = y;
		this.create();
		this.create();
	}

	public void moveLeft() {
		boolean isCreate = false;
		for (int i = 0; i < this.y; i++) {
			int zeroCount = 0;
			int tempData = -1;
			int dataIndex = -1;
			for (int j = 0; j < this.x; j++) {
				if (this.data[i][j] != 0) {
					if (tempData == this.data[i][j]) {
						this.data[i][dataIndex] += tempData;
						this.data[i][j] = 0;
						tempData = -1;
						zeroCount++;
						isCreate = true;
					} else {
						tempData = this.data[i][j];
						int index = j - zeroCount;
						if (index >= 0 && j != 0 && zeroCount != 0) {
							this.data[i][index] = this.data[i][j];
							this.data[i][j] = 0;
							dataIndex = index;
							isCreate = true;
						} else {

							dataIndex = j;
						}
					}
				} else {

					zeroCount++;
				}
			}
		}
		if (isCreate)
			this.create();
	}

	public void moveRight() {
		boolean isCreate = false;
		for (int i = 0; i < this.y; i++) {
			int zeroCount = 0;
			int tempData = -1;
			int dataIndex = -1;
			for (int j = this.x - 1; j >= 0; j--) {

				if (this.data[i][j] != 0) {

					if (tempData == this.data[i][j]) {

						this.data[i][dataIndex] += tempData;
						this.data[i][j] = 0;
						tempData = -1;
						zeroCount++;
						isCreate = true;
					} else {

						tempData = this.data[i][j];
						int index = j + zeroCount;
						if (index < this.x && j != (this.x - 1)
								&& zeroCount != 0) {

							this.data[i][index] = this.data[i][j];
							this.data[i][j] = 0;
							dataIndex = index;
							isCreate = true;
						} else {

							dataIndex = j;
						}
					}
				} else {

					zeroCount++;
				}
			}
		}
		if (isCreate)
			this.create();
	}

	public void moveUp() {
		boolean isCreate = false;
		for (int i = 0; i < this.x; i++) {
			int zeroCount = 0;
			int tempData = -1;
			int dataIndex = -1;
			for (int j = 0; j < this.y; j++) {

				if (this.data[j][i] != 0) {

					if (tempData == this.data[j][i]) {

						this.data[dataIndex][i] += tempData;
						this.data[j][i] = 0;
						tempData = -1;
						zeroCount++;
						isCreate = true;
					} else {

						tempData = this.data[j][i];
						int index = j - zeroCount;// �����Ҫ�ƶ�����λ��
						if (index >= 0 && j != 0 && zeroCount != 0) {

							this.data[index][i] = this.data[j][i];
							this.data[j][i] = 0;
							dataIndex = index;
							isCreate = true;
						} else {

							dataIndex = j;
						}
					}
				} else {

					zeroCount++;
				}
			}
		}
		if (isCreate)
			this.create();
	}

	public void moveDown() {
		boolean isCreate = false;
		for (int i = 0; i < this.x; i++) {
			int zeroCount = 0;
			int tempData = -1;
			int dataIndex = -1;
			for (int j = (this.y - 1); j >= 0; j--) {

				if (this.data[j][i] != 0) {

					if (tempData == this.data[j][i]) {

						this.data[dataIndex][i] += tempData;
						this.data[j][i] = 0;
						tempData = -1;
						zeroCount++;
						isCreate = true;
					} else {

						tempData = this.data[j][i];
						int index = j + zeroCount;// �����Ҫ�ƶ�����λ��
						if (index < this.y && j != (this.y - 1)
								&& zeroCount != 0) {

							this.data[index][i] = this.data[j][i];
							this.data[j][i] = 0;
							dataIndex = index;
							isCreate = true;
						} else {

							dataIndex = j;
						}
					}
				} else {

					zeroCount++;
				}
			}
		}
		if (isCreate)
			this.create();
	}

	public boolean isGameOver() {
		return this.isGameOver;
	}

	private final int createData[] ={2,4};
	
	private void create() {
		int x = 0;
		int y = 0;

		do {
			x = (int) Math.round(Math.random() * (this.x-1));
			y = (int) Math.round(Math.random() * (this.y-1));

			if (this.data[y][x] == 0) {
				this.data[y][x] = createData[(int) Math.round(Math.random() * 1)];

				break;
			}

		} while (true);
	}

	public int[][] getData() {
		return data;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
