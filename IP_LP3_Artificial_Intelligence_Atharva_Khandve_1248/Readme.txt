This code uses the python 'nltk' package for preprocessing the data.
To install nltk, run the following command:
pip install nltk

To test installation, run: import nltk

Further, this code also uses the 'punkt' and 'wordnet' models of nltk
to download these corpora, run:
nltk.download('punkt')
nltk.download('wordnet')

If you are running this code in spyder from anaconda navigator, make sure that your current working directory is set to the directory
in which the dataset is present.
If you are not using spyder, mention the entire path of the dataset when you read it.