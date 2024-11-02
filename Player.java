class Player{
	private String name;
	private int energy;
	private int minEnergySword;

	// This is just a constructor
	public Player(String name, int minEnergySword){
		this.name = name;
		this.minEnergySword = minEnergySword;
		this.energy = 0;
	}

	// We must to create the increment function
	public Player addEnergy(){
		this.energy += ((int) (Math.random() * 100));
		System.out.println(this.name + " earned " + this.energy + " points of energy");
		return this;
	}

	// And this is a method of this class
	public void fight(Player otherPlayer){
		// ternary's operations, if the energy is greater than the minimum value to obtain a sword I multiply it by ten, otherwise I keep the energy value
		int realEnergyThis = energy >= minEnergySword ? 10 * energy : energy;
		int realEnergyOtherPlayer = otherPlayer.energy >= otherPlayer.minEnergySword ? 10 * otherPlayer.energy : otherPlayer.energy;

		if (realEnergyThis > realEnergyOtherPlayer) {
			System.out.println(this.name + " won!");
			energy++;
			otherPlayer.energy--;
		} else if (realEnergyThis < realEnergyOtherPlayer) {
			System.out.println(otherPlayer.name + " won!");
			energy--;
			otherPlayer.energy++;
		}
		if (energy == 0 || otherPlayer.energy == 0) {
			System.out.println((energy == 0 ? otherPlayer.name : this.name) + " won!");
			System.exit(0);
		}
	}

	public static void main(String[] args){
		Player playerOne = new Player("Gracula", 10).addEnergy();
		Player playerTwo = new Player("Vampeta", 10).addEnergy();
		// 8 and 10 is the minimum necessary energy minimum to obtain a sword
		for(;;){
			playerTwo.fight(playerOne);
		}
	}
}
