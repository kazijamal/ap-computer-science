Kazi Jamal and Sunan Tajwar Period 1

1. 
    (A)
        public VoterBallots(List<Set<String>> ballotList) {
		    voteCount = new HashMap<String, Integer>();
		    for (Set<String> set : ballotList) {
			    for (String str : set) {
				    if (!voteCount.containsKey(str))
				        voteCount.put(str, 1);
				    else
					    voteCount.put(str, voteCount.get(str) + 1);
			    }
		    }
	    }
    (B)
        public Set<String> candidatesWithMost() {
		    Set<String> candidates = voteCount.keySet();
		    int max = maxVotes();
		    Iterator<String> itr = candidates.iterator();
		    while (itr.hasNext()) {
			    if (voteCount.get(itr.next()) != max) {
			    	itr.remove();
			    }
		    }
		    return candidates;
    	}
    (C)
2. 
    $ javac MorseCode.java
    $ java MorseCode
    input one of the following:
        a line beginning with a letter if you want it to be translated to morse code
        a line beginning with a period or hyphen with each sequence separated by spaces if you want it to be translated back to letters
    output will be one of the following:
        translation to morse code if input is a sequence of letters
        translation to letters with no spaces in between if input is in morse code
    end the program by entering a blank line
3.
    $ javac JumpingLeprechauns.java
    $ java JumpingLeprechauns <number of leprechauns> <number of iterations>
    run with number of leprechauns and number of iteration given as command line arguments
    output will print each leprechauns gold and horizon position for each iteration