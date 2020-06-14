from sklearn.feature_extraction.text import TfidfVectorizer
import pandas as pd
from sklearn.linear_model import PassiveAggressiveClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score


a=pd.read_csv('news.csv')
df = pd.DataFrame(a)
x=df['text']
y=df.label
x_train,x_test,y_train,y_test=train_test_split(x,y, test_size=0.15, random_state=1)


vectorizer=TfidfVectorizer(stop_words='english', max_df=0.7)

y1_train=vectorizer.fit_transform(x_train)
y1_test=vectorizer.transform(x_test)

#print(vectorizer.get_feature_names())
clf=PassiveAggressiveClassifier()
clf.fit(y1_train,y_train)
y_pred=clf.predict(y1_test)
score=accuracy_score(y_test,y_pred)
print('Accuracy Score :', (accuracy_score(y_test, y_pred)*100))
print('Confusion Matrix :')
print(confusion_matrix(y_test, y_pred))


