
# coding: utf-8

# IMPORTING NECESSARY PYTHON MODULES

# In[48]:


import pandas as pd
from sklearn.model_selection import train_test_split

from sklearn.feature_extraction.text import TfidfVectorizer
import matplotlib.pyplot as plt

from sklearn.linear_model import PassiveAggressiveClassifier
import sklearn.metrics as metrics
import numpy as np
import itertools
from sklearn.externals import joblib 


# READING THE DATASET AND EXPLORATION

# In[49]:


# Import `fake_or_real_news.csv` 
df = pd.read_csv("news.csv")
    
# Inspect shape of `df` 
df.shape

# Print first lines of `df` 
df.head()


# In[50]:


# Set index 
df = df.set_index("Unnamed: 0")

# Print first lines of `df` 
df.head()


# In[34]:


# Set `y` 
y = df.label 

# Drop the `label` column
df.drop("label", axis=1)

# Make training and test sets 
X_train, X_test, y_train, y_test = train_test_split(df['text'], y, test_size=0.33, random_state=53)


# BUILDING A TfidVectorizer

# In[35]:


# Initialize the `tfidf_vectorizer` 
tfidf_vectorizer = TfidfVectorizer(stop_words='english', max_df=0.7) 

# Fit and transform the training data 
tfidf_train = tfidf_vectorizer.fit_transform(X_train) 

# Transform the test set 
tfidf_test = tfidf_vectorizer.transform(X_test)


# In[36]:


# Get the feature names of `tfidf_vectorizer` 
print(tfidf_vectorizer.get_feature_names()[-10:])


# In[37]:


tfidf_df = pd.DataFrame(tfidf_train.A, columns=tfidf_vectorizer.get_feature_names())


# In[38]:


tfidf_df.head()


# FUNCTION TO PLOT CONFUSION MATRIX

# In[39]:


def plot_confusion_matrix(cm, classes,
                          normalize=False,
                          title='Confusion matrix',
                          cmap=plt.cm.Blues):
    """
    See full source and example: 
    http://scikit-learn.org/stable/auto_examples/model_selection/plot_confusion_matrix.html
    
    This function prints and plots the confusion matrix.
    Normalization can be applied by setting `normalize=True`.
    """
    plt.imshow(cm, interpolation='nearest', cmap=cmap)
    plt.title(title)
    plt.colorbar()
    tick_marks = np.arange(len(classes))
    plt.xticks(tick_marks, classes, rotation=45)
    plt.yticks(tick_marks, classes)

    if normalize:
        cm = cm.astype('float') / cm.sum(axis=1)[:, np.newaxis]
        print("Normalized confusion matrix")
    else:
        print('Confusion matrix, without normalization')

    thresh = cm.max() / 2.
    for i, j in itertools.product(range(cm.shape[0]), range(cm.shape[1])):
        plt.text(j, i, cm[i, j],
                 horizontalalignment="center",
                 color="white" if cm[i, j] > thresh else "black")

    plt.tight_layout()
    plt.ylabel('True label')
    plt.xlabel('Predicted label')


# MODEL BUILDING

# In[40]:


linear_clf = PassiveAggressiveClassifier()


# MODEL FITTING

# In[42]:


linear_clf.fit(tfidf_train, y_train)


# CALCULATING THE ACCURRACY AND PLOTTING THE CONFUSION MATRIX

# In[53]:



pred = linear_clf.predict(tfidf_test)
score = metrics.accuracy_score(y_test, pred)
print("accuracy:   %0.3f" % score)
cm = metrics.confusion_matrix(y_test, pred, labels=['FAKE', 'REAL'])
plot_confusion_matrix(cm, classes=['FAKE', 'REAL'])


# MODEL SAVING

# In[46]:


joblib.dump(linear_clf, 'model.pkl')

