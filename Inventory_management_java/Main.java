package com.curonex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.curonex.dao.ResourceDAO;
import com.curonex.dao.ResourceTransferDAO;
import com.curonex.dao.impl.ResourceDAOImpl;
import com.curonex.dao.impl.ResourceTransferDAOImpl;
import com.curonex.enums.ResourceAvailabilityEnum;
import com.curonex.enums.ResourceCategoryEnum;
import com.curonex.enums.TransferStatusEnum;
import com.curonex.exception.ResourceDAOException;
import com.curonex.exception.ResourceTransferDAOException;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final ResourceDAO resourceDAO =
            new ResourceDAOImpl();

    private static final ResourceTransferDAO transferDAO =
            new ResourceTransferDAOImpl();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("     CURONEX INVENTORY MANAGEMENT");
            System.out.println("========================================");

            System.out.println("1. Resource Management");
            System.out.println("2. Transfer Management");
            System.out.println("3. Exit");

            System.out.print("\nEnter Choice : ");

            choice = readInt();

            switch (choice) {

                case 1:
                    resourceMenu();
                    break;

                case 2:
                    transferMenu();
                    break;

                case 3:
                    System.out.println("\nThank You for using Curonex.");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 3);

        sc.close();

    }

    /*=========================================================
                    RESOURCE MENU
    =========================================================*/

    private static void resourceMenu() {

        int choice;

        do {

            System.out.println("\n============== RESOURCE MENU ==============");

            System.out.println("1. Add Resource");
            System.out.println("2. View All Resources");
            System.out.println("3. Search Resource");
            System.out.println("4. Update Resource");
            System.out.println("5. Delete Resource");
            System.out.println("6. Filter By Category");
            System.out.println("7. Filter By Hospital");
            System.out.println("8. Filter By Availability");
            System.out.println("9. Back");

            System.out.print("\nEnter Choice : ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addResource();
                    break;

                case 2:
                    viewAllResources();
                    break;

                case 3:
                    searchResource();
                    break;

                case 4:
                    updateResource();
                    break;

                case 5:
                    deleteResource();
                    break;

                case 6:
                    filterByCategory();
                    break;

                case 7:
                    filterByHospital();
                    break;

                case 8:
                    filterByAvailability();
                    break;

                case 9:
                    break;

                default:
                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 9);

    }

    /*=========================================================
                    TRANSFER MENU
    =========================================================*/

    private static void transferMenu() {

        int choice;

        do {

            System.out.println("\n============== TRANSFER MENU ==============");

            System.out.println("1. Add Transfer");
            System.out.println("2. View All Transfers");
            System.out.println("3. Search Transfer");
            System.out.println("4. Update Transfer");
            System.out.println("5. Delete Transfer");
            System.out.println("6. Filter By Resource");
            System.out.println("7. Filter By Source Hospital");
            System.out.println("8. Filter By Destination Hospital");
            System.out.println("9. Filter By Status");
            System.out.println("10. Back");

            System.out.print("\nEnter Choice : ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addTransfer();
                    break;

                case 2:
                    viewAllTransfers();
                    break;

                case 3:
                    searchTransfer();
                    break;

                case 4:
                    updateTransfer();
                    break;

                case 5:
                    deleteTransfer();
                    break;

                case 6:
                    filterTransferByResource();
                    break;

                case 7:
                    filterTransferBySourceHospital();
                    break;

                case 8:
                    filterTransferByDestinationHospital();
                    break;

                case 9:
                    filterTransferByStatus();
                    break;

                case 10:
                    break;

                default:
                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 10);

    }

    /*=========================================================
                    HELPER METHODS
    =========================================================*/

    private static int readInt() {

        while (!sc.hasNextInt()) {

            System.out.print("Enter a valid number : ");
            sc.next();

        }

        int value = sc.nextInt();
        sc.nextLine();

        return value;

    }

    private static LocalDate readDate(String fieldName) {

        System.out.println("\nEnter " + fieldName + " (yyyy-mm-dd)");

        while (true) {

            try {

                return LocalDate.parse(sc.nextLine());

            } catch (Exception e) {

                System.out.print(
                        "Invalid Date. Re-enter : ");

            }

        }

    }

    private static ResourceCategoryEnum readCategory() {

      while (true) {
  
          System.out.println("\nSelect Category");
          System.out.println("1. Medicine");
          System.out.println("2. Equipment");
          System.out.println("3. Consumable");
          System.out.println("4. Other");
  
          System.out.print("Enter Choice : ");
  
          int choice = readInt();
  
          switch (choice) {
  
              case 1:
                  return ResourceCategoryEnum.MEDICINE;
  
              case 2:
                  return ResourceCategoryEnum.EQUIPMENT;
  
              case 3:
                  return ResourceCategoryEnum.CONSUMABLE;
  
              case 4:
                  return ResourceCategoryEnum.OTHER;
  
              default:
                  System.out.println(
                          "\nInvalid Category! Please try again.");
  
          }
  
      }
  
  }

    private static ResourceAvailabilityEnum
            getAvailability(int quantity) {

        if (quantity <= 0)

            return ResourceAvailabilityEnum.OUT_OF_STOCK;

        if (quantity <= 20)

            return ResourceAvailabilityEnum.LOW_STOCK;

        return ResourceAvailabilityEnum.AVAILABLE;

    }

  private static TransferStatusEnum readTransferStatus() {
  
      while (true) {
  
          System.out.println("\nSelect Transfer Status");
          System.out.println("1. Pending");
          System.out.println("2. In Transit");
          System.out.println("3. Completed");
          System.out.println("4. Cancelled");
  
          System.out.print("Enter Choice : ");
  
          int choice = readInt();
  
          switch (choice) {
  
              case 1:
                  return TransferStatusEnum.PENDING;
  
              case 2:
                  return TransferStatusEnum.IN_TRANSIT;
  
              case 3:
                  return TransferStatusEnum.COMPLETED;
  
              case 4:
                  return TransferStatusEnum.CANCELLED;
  
              default:
                  System.out.println(
                          "\nInvalid Status! Please try again.");
  
          }
  
      }
  
  }


/*=========================================================
                    UPDATE RESOURCE
=========================================================*/

private static void updateResource() {

    try {

        System.out.print("\nEnter Resource ID to Update : ");
        long id = readInt();

        Resources resource = resourceDAO.getResourceById(id);

        System.out.print("Resource Name : ");
        resource.setName(sc.nextLine());

        resource.setCategory(readCategory());

        System.out.print("\nUnits : ");
        resource.setUnits(sc.nextLine());

        System.out.print("Supplier : ");
        resource.setSupplier(sc.nextLine());

        resource.setManufacturing_date(
                readDate("Manufacturing Date"));

        resource.setExpiry_date(
                readDate("Expiry Date"));

        System.out.print("\nQuantity : ");
        int quantity = readInt();

        resource.setQuantity(quantity);

        resource.setAvailability_status(
                getAvailability(quantity));

        System.out.print("Hospital ID : ");
        resource.setHospital_id(readInt());

        resourceDAO.updateResource(resource);

        System.out.println("\nResource Updated Successfully.");

    } catch (ResourceDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                FILTER BY CATEGORY
=========================================================*/

private static void filterByCategory() {

    try {

        ResourceCategoryEnum category = readCategory();

        List<Resources> resources =
                resourceDAO.getResourcesByCategory(category);

        if (resources.isEmpty()) {

            System.out.println("\nNo Resources Found.");

            return;

        }

        resources.forEach(System.out::println);

    } catch (ResourceDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                FILTER BY HOSPITAL
=========================================================*/

private static void filterByHospital() {

    try {

        System.out.print("\nEnter Hospital ID : ");

        long hospitalId = readInt();

        List<Resources> resources =
                resourceDAO.getResourcesByHospital(hospitalId);

        if (resources.isEmpty()) {

            System.out.println("\nNo Resources Found.");

            return;

        }

        resources.forEach(System.out::println);

    } catch (ResourceDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                FILTER BY AVAILABILITY
=========================================================*/

private static void filterByAvailability() {

    try {

        System.out.println("\nSelect Availability");

        System.out.println("1. Available");
        System.out.println("2. Low Stock");
        System.out.println("3. Out Of Stock");

        System.out.print("Enter Choice : ");

        ResourceAvailabilityEnum status;

        switch (readInt()) {

            case 1:
                status = ResourceAvailabilityEnum.AVAILABLE;
                break;

            case 2:
                status = ResourceAvailabilityEnum.LOW_STOCK;
                break;

            case 3:
                status = ResourceAvailabilityEnum.OUT_OF_STOCK;
                break;

            default:
                System.out.println("\nInvalid Choice.");
                return;

        }

        List<Resources> resources =
                resourceDAO.getResourcesByAvailability(status);

        if (resources.isEmpty()) {

            System.out.println("\nNo Resources Found.");

            return;

        }

        resources.forEach(System.out::println);

    } catch (ResourceDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}


/*=========================================================
                    ADD TRANSFER
=========================================================*/

private static void addTransfer() {

    try {

        System.out.println("\n========== ADD TRANSFER ==========");

        System.out.print("Transfer ID : ");
        long transferId = readInt();

        System.out.print("Resource ID : ");
        long resourceId = readInt();

        System.out.print("Source Hospital ID : ");
        long sourceHospitalId = readInt();

        System.out.print("Destination Hospital ID : ");
        long destinationHospitalId = readInt();

        System.out.print("Quantity : ");
        int quantity = readInt();

        TransferStatusEnum status = readTransferStatus();

        ResourceTransfers transfer =
                new ResourceTransfers(
                        transferId,
                        resourceId,
                        sourceHospitalId,
                        destinationHospitalId,
                        quantity,
                        LocalDateTime.now(),
                        status);

        transferDAO.addTransfer(transfer);

        System.out.println("\nTransfer Added Successfully.");

    } catch (ResourceTransferDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                VIEW ALL TRANSFERS
=========================================================*/

private static void viewAllTransfers() {

    try {

        List<ResourceTransfers> transfers =
                transferDAO.getAllTransfers();

        if (transfers.isEmpty()) {

            System.out.println("\nNo Transfers Found.");

            return;

        }

        transfers.forEach(System.out::println);

    } catch (ResourceTransferDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                SEARCH TRANSFER
=========================================================*/

private static void searchTransfer() {

    try {

        System.out.print("\nEnter Transfer ID : ");

        long transferId = readInt();

        ResourceTransfers transfer =
                transferDAO.getTransferById(transferId);

        System.out.println("\n" + transfer);

    } catch (ResourceTransferDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
                DELETE TRANSFER
=========================================================*/

private static void deleteTransfer() {

    try {

        System.out.print("\nEnter Transfer ID : ");

        long transferId = readInt();

        if (transferDAO.deleteTransfer(transferId)) {

            System.out.println(
                    "\nTransfer Deleted Successfully.");

        }

    } catch (ResourceTransferDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}


/*=========================================================
                    UPDATE TRANSFER
=========================================================*/

private static void updateTransfer() {

    try {

        System.out.print("\nEnter Transfer ID to Update : ");

        long transferId = readInt();

        ResourceTransfers transfer =
                transferDAO.getTransferById(transferId);

        System.out.print("Resource ID : ");
        transfer.setResource_id(readInt());

        System.out.print("Source Hospital ID : ");
        transfer.setSource_hospital_id(readInt());

        System.out.print("Destination Hospital ID : ");
        transfer.setDestination_hospital_id(readInt());

        System.out.print("Quantity : ");
        transfer.setQuantity(readInt());

        transfer.setTransfer_date(LocalDateTime.now());

        transfer.setTransfer_status(
                readTransferStatus());

        transferDAO.updateTransfer(transfer);

        System.out.println(
                "\nTransfer Updated Successfully.");

    } catch (ResourceTransferDAOException e) {

        System.out.println("Error : " + e.getMessage());

    }

}

/*=========================================================
            FILTER BY RESOURCE
=========================================================*/

private static void filterTransferByResource() {

    try {

        System.out.print("\nEnter Resource ID : ");

        long resourceId = readInt();

        List<ResourceTransfers> transfers =
                transferDAO.getTransfersByResource(
                        resourceId);

        if (transfers.isEmpty()) {

            System.out.println(
                    "\nNo Transfers Found.");

            return;

        }

        transfers.forEach(System.out::println);

    } catch (ResourceTransferDAOException e) {

        System.out.println(
                "Error : " + e.getMessage());

    }

}

/*=========================================================
        FILTER BY SOURCE HOSPITAL
=========================================================*/

private static void filterTransferBySourceHospital() {

    try {

        System.out.print(
                "\nEnter Source Hospital ID : ");

        long hospitalId = readInt();

        List<ResourceTransfers> transfers =
                transferDAO
                        .getTransfersBySourceHospital(
                                hospitalId);

        if (transfers.isEmpty()) {

            System.out.println(
                    "\nNo Transfers Found.");

            return;

        }

        transfers.forEach(System.out::println);

    } catch (ResourceTransferDAOException e) {

        System.out.println(
                "Error : " + e.getMessage());

    }

}

/*=========================================================
    FILTER BY DESTINATION HOSPITAL
=========================================================*/

private static void
filterTransferByDestinationHospital() {

    try {

        System.out.print(
                "\nEnter Destination Hospital ID : ");

        long hospitalId = readInt();

        List<ResourceTransfers> transfers =
                transferDAO
                .getTransfersByDestinationHospital(
                        hospitalId);

        if (transfers.isEmpty()) {

            System.out.println(
                    "\nNo Transfers Found.");

            return;

        }

        transfers.forEach(System.out::println);

    } catch (ResourceTransferDAOException e) {

        System.out.println(
                "Error : " + e.getMessage());

    }

}

/*=========================================================
            FILTER BY STATUS
=========================================================*/

private static void filterTransferByStatus() {

    try {

        TransferStatusEnum status =
                readTransferStatus();

        List<ResourceTransfers> transfers =
                transferDAO.getTransfersByStatus(
                        status);

        if (transfers.isEmpty()) {

            System.out.println(
                    "\nNo Transfers Found.");

            return;

        }

        transfers.forEach(System.out::println);

    } catch (ResourceTransferDAOException e) {

        System.out.println(
                "Error : " + e.getMessage());

    }

}
}



