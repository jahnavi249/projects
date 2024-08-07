
# Importing necessary Java classes from AWT
from java.awt import FlowLayout, Frame, Label, Button, TextArea
from javax.swing import JOptionPane
from javax.swing import JFrame
from java.awt.event import ActionListener

# Importing Python libraries for machine learning
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.ensemble import RandomForestClassifier

# Mock data for demonstration purposes
fake_data = ["fake website content 1", "fake website content 2", "fake threat content"]
legit_data = ["legitimate website content 1", "legitimate website content 2", "normal content"]

# Labeling the data
fake_labels = [1] * len(fake_data)
legit_labels = [0] * len(legit_data)

# Combine fake and legitimate data
all_data = fake_data + legit_data
all_labels = fake_labels + legit_labels

# Convert text data to feature vectors using TF-IDF vectorizer
vectorizer = TfidfVectorizer()
X = vectorizer.fit_transform(all_data)

# Train a RandomForestClassifier
classifier = RandomForestClassifier()
classifier.fit(X, all_labels)

# Action listener for the button
class DetectFakeContentActionListener(ActionListener):
    def actionPerformed(self, event):
        # Get the content from the text area
        content = text_area.getText()

        # Convert the content to a feature vector using the same TF-IDF vectorizer
        content_vector = vectorizer.transform([content])

        # Make a prediction using the trained classifier
        prediction = classifier.predict(content_vector)

        # Display the result using a JOptionPane dialog
        if prediction == 1:
            JOptionPane.showMessageDialog(frame, "This content is likely fake or a threat!", "Cybersecurity Assistant", JOptionPane.INFORMATION_MESSAGE)
        else:
            JOptionPane.showMessageDialog(frame, "This content appears to be legitimate.", "Cybersecurity Assistant", JOptionPane.INFORMATION_MESSAGE)


# Create the main frame
frame = JFrame("Cybersecurity Assistant")
frame.setSize(400, 300)
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

# Create GUI components
text_area = TextArea()
detect_button = Button("Detect Fake Content")
detect_button.addActionListener(DetectFakeContentActionListener())

# Set layout manager
frame.setLayout(FlowLayout())

# Add components to the frame
frame.add(Label("Enter content:"))
frame.add(text_area)
frame.add(detect_button)

# Make the frame visible
frame.setVisible(True)
