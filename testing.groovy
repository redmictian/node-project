#!/usr/bin/env groovy
def testNode() {
	echo 'Testing the app'
	sh 'npm --prefix ./app test'
}
return this
