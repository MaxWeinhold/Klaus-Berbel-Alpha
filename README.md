# Klaus-Berbel-Alpha
Klaus Berbel Alpha is a Java algorithm that can break down German sentences grammatically and rephrase them into counter-questions in order to carry on a conversation.

The idea was to write an algorithm capable of understanding, rephrasing and storing the content of sentences through grammatical analysis. 

Klaus Berbel Alpha compares each word of a sentence with a word database in which information about the grammatical circumstances is determined and then tries, if possible, to recognise the grammatical case of the nouns used in order to formulate and store the corresponding counter-questions. Even if this is not possible, or if a grammatically incorrect counter-question is stored, Klaus Berbel Alpha is always able to recognise the sentence as a yes-no counter-question.

Example:
I say to Klaus Berbel Alpha:
The earth is a sphere.

Klaus Berbel Alpha understand this and remember the question:
is the earth a sphere

Klaus Berbel Alpha also remembers the answer. The answer to this is: Yes

If I now intend to ask Klaus Berbel Alpha whether the earth is a sphere, Klaus Berbel Alpha can provide me with the answer.

Klaus Berbel Alpha communicates exclusively in German. Only nouns are written in capital letters. All other words are written in lower case, even if they are at the beginning of a sentence. Klaus Berbel Alpha is not able to recognise spelling mistakes because it is a very simple algorithm.

Klaus Berbel is equipped with only a very limited vocabulary, but is able to learn words through the context in the sentence. For example, it can recognise nouns by an article. It then asks the user whether this unknown word could be a noun or an infinite adjective.

This project is very old. My motivation was solely based on the pleasant pastime. However, the programme also contains errors that I can no longer correct.
