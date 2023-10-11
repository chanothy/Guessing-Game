# Guessing Game App

Guessing game with database functionality.

## Functionality 

The following **required** functionality is completed:

* [ ] User sees main screen with play and high score options
* [ ] User can see previous high scores in ordered format
* [ ] User can hear and see toast that indicates incorrect guess
* [ ] User can see attempts
* [ ] When correct guess is made, main screen changes
* [ ] When correct guess is made, database stores current attempt
* [ ] Database allows for deletion of scores

The following **extensions** are implemented:

* id("com.google.devtools.ksp")
* id("androidx.navigation.safeargs")
* implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
* implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
* implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
* implementation ("androidx.room:room-runtime:$room_version")
* implementation ("androidx.room:room-ktx:$room_version")
* ksp("androidx.room:room-compiler:2.4.1")

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/chanothy/MidtermApp/blob/master/midtermAppDemo.gif' title='Video Walkthrough' width='50%' alt='Video Walkthrough' />

<img src='https://github.com/chanothy/MidtermApp/blob/master/midtermAppDemoHorizontal.gif' title='Video Walkthrough Horizontal' width='50%' alt='Video Walkthrough Horizontal' />


GIFs created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
One of the challenges was getting all the generated boilerplate code from the safe args, Dao, etc to work. Sometimes the gradle configuration was an issue and sometimes the XML had to be configured very specifically for the boilerplate to work. Another problem I had was getting both Play fragments to work with the same viewModel. It was easy to do with the non-Dao version of the viewModel, using a Dao made it generate a new viewModel each time, so I had to figure out how to force both of them to use the same generated viewMode.

## License

    Copyright [2023] [Timothy Chan]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
