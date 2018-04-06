package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.THREE, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());

	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.FourOfAKind, HSP.geteHandStrength());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(1, HSP.getKickers().size());
		assertEquals(eRank.TWO, HSP.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, HSP.getKickers().get(0).geteSuit());

	}
	
	@Test
	public void StraightTest1() {
		System.out.println("A Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.SEVEN, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	@Test
	public void StraightTest2() {
		System.out.println("A Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	@Test
	public void StraightTest3() {
		System.out.println("A Stringt");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.Straight, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());

	}
	
	
	@Test
	public void StraightTest4() {
		System.out.println("A Stringt");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		

	}

	public void RoyalFlushTest1() {
		System.out.println("A RoyalFlush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HandScorePoker HSP = hp.getHSP();

		assertEquals(eHandStrength.RoyalFlush, HSP.geteHandStrength());
		assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
		assertNull(HSP.getKickers());
	}
		public void RoyalFlushTest2() {
			System.out.println("A RoyalFlush");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.RoyalFlush, HSP.geteHandStrength());
			assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		
		public void StraightFlushTest1() {
			System.out.println("A StraightFlush");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
			assertEquals(eRank.KING, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void StraightFlushTest2() {
			System.out.println("A StraightFlush");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.StraightFlush, HSP.geteHandStrength());
			assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void FullHouseTest1() {
			System.out.println("A FullHouse");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
			hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.FullHouse, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		
		public void FullHouseTest2() {
			System.out.println("A FullHouse");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
			hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.FullHouse, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void FlushTest1() {
			System.out.println("A Flush");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.Flush, HSP.geteHandStrength());
			assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void FlushTest2() {
			System.out.println("A Flush");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.Flush, HSP.geteHandStrength());
			assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void ThreeOfAKindTest1() {
			System.out.println("A ThreeOfAKind");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
			hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void ThreeOfAKindTest2() {
			System.out.println("A ThreeOfAKind");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
			hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.ThreeOfAKind, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void TwoPairTest1() {
			System.out.println("A TwoPair");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
			assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void TwoPairTest2() {
			System.out.println("A TwoPair");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.TwoPair, HSP.geteHandStrength());
			assertEquals(eRank.QUEEN, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void PairTest1() {
			System.out.println("A Pair");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.Pair, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		
		public void PairTest2() {
			System.out.println("A Pair");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));

			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.Pair, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void HighCardTest1() {
			System.out.println("A HighCard");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));

			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
			assertEquals(eRank.JACK, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		}
		public void HighCardTest2() {
			System.out.println("A HighCard");
			System.out.println("");
			HandPoker hp = new HandPoker();
			hp.AddCard(new Card(eSuit.HEARTS, eRank.TEN));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
			hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
			hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));


			try {
				hp.ScoreHand();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HandScorePoker HSP = hp.getHSP();

			assertEquals(eHandStrength.HighCard, HSP.geteHandStrength());
			assertEquals(eRank.ACE, HSP.getHiCard().geteRank());
			assertNull(HSP.getKickers());
		

		}



}
