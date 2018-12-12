package hello;

import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
	@Override
	public ResponseBean getWordStatus(String word) {
		ResponseBean res = null;
		if (null != word) {
			res = new ResponseBean();
			res.setWord(word);
			res.setPalindrome(isPalindrome(word));
			res.setAnagramOfPalindrome(isAnagramPalindrome(word));
		}
		return res;
	}

	private static boolean isAnagramPalindrome(String word) {
		int oddOccur = 0;
		int[] count = new int[256];

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			count[ch]++;
		}

		for (int cnt : count) {
			if (oddOccur > 1) {
				return false;
			}
			if (cnt % 2 == 1) {
				oddOccur++;
			}
		}
		return true;
	}

	private static boolean isPalindrome(String word) {
		String revWord = "";
		int n = word.length();
		for (int i = n - 1; i >= 0; i--) {
			revWord = revWord + word.charAt(i);
		}
		if (word.equalsIgnoreCase(revWord)) {
			return true;
		} else {
			return false;
		}
	}
}
