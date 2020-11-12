Feature: Multi lang test
  Scenario: testing if Germany (Deutschland)  version is qccesible
    Given  use open page in the url "https://www.amazon.com/"
    #And   the page Title should containe "Amazon.com: Online Shopping"
    And   user sould land in a page title contains "Amazon.com: Online Shopping"
    # link: multilangues flag.
    And   use go over the element determined by id "icp-nav-flyout"
    #And  user white tell element identefied by "nav-flyout-icp" sows up
    And  user white tell element identefied by "icp-flyout-mkt-change" sows up
    # link: Change country/region.
    And   user click on element determined by the id"icp-flyout-mkt-change"
    And   user sould land in a page title contains "Go to website"
    #    icp-selected-country
    And   user click on element determined by the id"a-autoid-0-announce"
    #And   user click on tagElement "span" having as content"France"
    And   user click on tagElement "span" having as content"Germany (Deutschland)"
    #And   user click on element determined by the xpath"//span[text()='France']"
    #And  user click on tagElement "span" having as content"Go to website"
    #And user click on  tagElement "span" contaning in "Go to website"
    And user click on  parent of  tagElement "span" contaning in "Go to website"
    And   user sould land in new tab were page title contains "Amazon.de"


    # test if multilanguages functions are working corrctely
    # use open page in the url "https://www.amazon.com/"
    #
    #
