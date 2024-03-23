sudo apt-get install mailutils
echo "$MAIL_BODY" | mail -s "$MAIL_SUBJECT" $MAIL_TO
echo "Sent email to $MAIL_TO \n Subject: \n$MAIL_SUBJECT \n Body: \n$MAIL_BODY"